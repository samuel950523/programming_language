import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SEOUL05_SEOJEONGJOON {

	// User and Launcher Information
	static final String NICKNAME = "SEOUL05_SEOJEONGJOON";
	static final String HOST = "127.0.0.1";

	// Static Value(Do not modify)
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// Predefined Variables(Do not modify)
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		int[][] balls = new int[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");
			boolean flag = false;
			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						/** 공 데이터를 읽는다. */
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Integer.parseInt(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = balls[0][1]; /** 선공 후공 */
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) { /** 공 위치 읽기 */
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// Beginning of Your Code
				// Put your code here to set angle and power values.
				// angle(float) must be between 0.0 and 360.0
				// power(float) must be between 0.0 and 100.0
				int wbx = balls[0][0]; // 흰공 x
				int wby = balls[0][1]; // 흰공 y

				int tbx = balls[1][0]; // 타겟 x
				int tby = balls[1][1]; // 타겟볼 y

				/** 공: 직경 5.72(cm) */
				double width = Math.abs(tbx - wbx);
				double height = Math.abs(tby - wby);

				double radian = Math.atan(width / height);
				if (height == 0)
					height = 1;
				double distance = Math.sqrt((width * width) + (height * height));

				angle = (float) ((180.0 / Math.PI) * radian);
				power = (float) distance;

				if (order == 1) { // 선공일때

					if (balls[1][0] != -1) { // 1번공이 존재할때
						tbx = balls[1][0];
						tby = balls[1][1];

						int hx = 0;
						int hy = 0;
						// 타겟공을 넣기 좋은 구멍 찾기
						// { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
						// 일직선상 라인 찾기
						if (tbx < 127 / 2 && tby < 127 / 2) { // 0,0
							hx = 0;
							hy = 0;
						}
						if (tbx >= 127 / 2 && tbx <= 127 + 127 / 2 && tby >= 127 / 2) { // 127,127
							hx = 127;
							hy = 127;
						}
						if (tbx > 127 + 127 / 2 && tby > 127 / 2) { // 254,127
							hx = 254;
							hy = 127;
						}
						if (tbx >= 127 / 2 && tbx >= 127 + 127 / 2 && tby <= 127 / 2) { // 127,0
							hx = 127;
							hy = 0;
						}

						if (tbx > 127 + 127 / 2 && tby < 127 / 2) { // 254,0
							hx = 254;
							hy = 0;
						}

						width = Math.abs(tbx - wbx);
						height = Math.abs(tby - wby);
						radian = Math.atan(width / height);
						if (height == 0)
							height = 1;
						double newRad = getRadian(wbx, wby, tbx, tby, radian);
						if (Math.abs(tby - hy) == 0)
							hy += 1;
						double hole = getRadian(tbx, tby, hx, hy, Math.atan((Math.abs(tbx - hx)) / Math.abs(tby - hy)));
						distance = Math.sqrt((width * width) + (height * height));

						if (newRad == hole) // 일직선
							angle = (float) ((180.0 / Math.PI) * newRad); // 그냥 치기
						else {
							if (wby > tby)
								angle = (float) ((180.0 / Math.PI) * newRad - 1);
							else {
								angle = (float) ((180.0 / Math.PI) * newRad + 1);
								System.out.println(1111);
							}
						}
						power = (float) distance;
					}
					if (balls[1][0] == -1 && balls[3][0] != -1) { // 3번 차례
						tbx = balls[3][0];
						tby = balls[3][1];

						int hx = 0;
						int hy = 0;
						// 타겟공을 넣기 좋은 구멍 찾기
						// { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
						// 일직선상 라인 찾기
						if (tbx < 127 / 2 && tby < 127 / 2) { // 0,0
							hx = 0;
							hy = 0;
						}
						if (tbx >= 127 / 2 && tbx <= 127 + 127 / 2 && tby >= 127 / 2) { // 127,127
							hx = 127;
							hy = 127;
						}
						if (tbx > 127 + 127 / 2 && tby > 127 / 2) { // 254,127
							hx = 254;
							hy = 127;
						}
						if (tbx >= 127 / 2 && tbx >= 127 + 127 / 2 && tby <= 127 / 2) { // 127,0
							hx = 127;
							hy = 0;
						}

						if (tbx > 127 + 127 / 2 && tby < 127 / 2) { // 254,0
							hx = 254;
							hy = 0;
						}

						width = Math.abs(tbx - wbx);
						height = Math.abs(tby - wby);
						radian = Math.atan(width / height);
						if (height == 0)
							height = 1;
						double newRad = getRadian(wbx, wby, tbx, tby, radian);
						if (Math.abs(tby - hy) == 0)
							hy += 1;
						double hole = getRadian(tbx, tby, hx, hy, Math.atan((Math.abs(tbx - hx)) / Math.abs(tby - hy)));
						distance = Math.sqrt((width * width) + (height * height));
						if (newRad == hole) // 일직선
							angle = (float) ((180.0 / Math.PI) * newRad); // 그냥 치기
						else {
							if (wby > tby)
								angle = (float) ((180.0 / Math.PI) * newRad - 1);
							else {
								angle = (float) ((180.0 / Math.PI) * newRad + 1);
								System.out.println(1111);
							}
						}
						power = (float) distance;
					}
					if (balls[1][0] == -1 && balls[3][0] == -1 && balls[5][0] != -1) { // 8번 차례
						tbx = balls[5][0];
						tby = balls[5][1];

						int hx = 0;
						int hy = 0;
						// 타겟공을 넣기 좋은 구멍 찾기
						// { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
						// 일직선상 라인 찾기
						if (tbx < 127 / 2 && tby < 127 / 2) { // 0,0
							hx = 0;
							hy = 0;
						}
						if (tbx >= 127 / 2 && tbx <= 127 + 127 / 2 && tby >= 127 / 2) { // 127,127
							hx = 127;
							hy = 127;
						}
						if (tbx > 127 + 127 / 2 && tby > 127 / 2) { // 254,127
							hx = 254;
							hy = 127;
						}
						if (tbx >= 127 / 2 && tbx >= 127 + 127 / 2 && tby <= 127 / 2) { // 127,0
							hx = 127;
							hy = 0;
						}

						if (tbx > 127 + 127 / 2 && tby < 127 / 2) { // 254,0
							hx = 254;
							hy = 0;
						}

						width = Math.abs(tbx - wbx);
						height = Math.abs(tby - wby);
						radian = Math.atan(width / height);
						if (height == 0)
							height = 1;
						double newRad = getRadian(wbx, wby, tbx, tby, radian);
						if (Math.abs(tby - hy) == 0)
							hy += 1;
						double hole = getRadian(tbx, tby, hx, hy, Math.atan((Math.abs(tbx - hx)) / Math.abs(tby - hy)));
						distance = Math.sqrt((width * width) + (height * height));

						if (newRad == hole) // 일직선
							angle = (float) ((180.0 / Math.PI) * newRad); // 그냥 치기
						else {
							if (wby > tby)
								angle = (float) ((180.0 / Math.PI) * newRad - 1.1);
							else {
								angle = (float) ((180.0 / Math.PI) * newRad + 1.1);
								System.out.println(1111);
							}
						}
						power = (float) distance;
					}
				} else {
					if (balls[2][0] != -1) { // 2번공이 존재할때
						tbx = balls[2][0];
						tby = balls[2][1];
						int hx = 0;
						int hy = 0;
						// 타겟공을 넣기 좋은 구멍 찾기
						// { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
						// 일직선상 라인 찾기
						if (tbx < 127 / 2 && tby < 127 / 2) { // 0,0
							hx = 0;
							hy = 0;
						}
						if (tbx >= 127 / 2 && tbx <= 127 + 127 / 2 && tby >= 127 / 2) { // 127,127
							hx = 127;
							hy = 127;
						}
						if (tbx > 127 + 127 / 2 && tby > 127 / 2) { // 254,127
							hx = 254;
							hy = 127;
						}
						if (tbx >= 127 / 2 && tbx >= 127 + 127 / 2 && tby <= 127 / 2) { // 127,0
							hx = 127;
							hy = 0;
						}

						if (tbx > 127 + 127 / 2 && tby < 127 / 2) { // 254,0
							hx = 254;
							hy = 0;
						}

						width = Math.abs(tbx - wbx);
						height = Math.abs(tby - wby);
						radian = Math.atan(width / height);
						if (height == 0)
							height = 1;
						double newRad = getRadian(wbx, wby, tbx, tby, radian);
						if (Math.abs(tby - hy) == 0)
							hy += 1;
						double hole = getRadian(tbx, tby, hx, hy, Math.atan((Math.abs(tbx - hx)) / Math.abs(tby - hy)));
						distance = Math.sqrt((width * width) + (height * height));

						if (newRad == hole) // 일직선
							angle = (float) ((180.0 / Math.PI) * newRad); // 그냥 치기
						else {
							if (wby > tby)
								angle = (float) ((180.0 / Math.PI) * newRad - 1);
							else {
								angle = (float) ((180.0 / Math.PI) * newRad + 1.1);
								System.out.println(1111);
							}
						}
						power = (float) distance;
					}

					if (balls[2][0] == -1 && balls[4][0] != -1) { // 4번공이 존재할때
						tbx = balls[4][0];
						tby = balls[4][1];

						int hx = 0;
						int hy = 0;
						// 타겟공을 넣기 좋은 구멍 찾기
						// { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
						// 일직선상 라인 찾기
						if (tbx < 127 / 2 && tby < 127 / 2) { // 0,0
							hx = 0;
							hy = 0;
						}
						if (tbx >= 127 / 2 && tbx <= 127 + 127 / 2 && tby >= 127 / 2) { // 127,127
							hx = 127;
							hy = 127;
						}
						if (tbx > 127 + 127 / 2 && tby > 127 / 2) { // 254,127
							hx = 254;
							hy = 127;
						}
						if (tbx >= 127 / 2 && tbx >= 127 + 127 / 2 && tby <= 127 / 2) { // 127,0
							hx = 127;
							hy = 0;
						}

						if (tbx > 127 + 127 / 2 && tby < 127 / 2) { // 254,0
							hx = 254;
							hy = 0;
						}

						width = Math.abs(tbx - wbx);
						height = Math.abs(tby - wby);
						radian = Math.atan(width / height);
						if (height == 0)
							height = 1;
						double newRad = getRadian(wbx, wby, tbx, tby, radian);
						if (Math.abs(tby - hy) == 0)
							hy += 1;
						double hole = getRadian(tbx, tby, hx, hy, Math.atan((Math.abs(tbx - hx)) / Math.abs(tby - hy)));
						distance = Math.sqrt((width * width) + (height * height));

						if (newRad == hole) // 일직선
							angle = (float) ((180.0 / Math.PI) * newRad); // 그냥 치기
						else {
							if (wby > tby)
								angle = (float) ((180.0 / Math.PI) * newRad - 1);
							else {
								angle = (float) ((180.0 / Math.PI) * newRad + 1.1);
								System.out.println(1111);
							}
						}
						power = (float) distance;
					}

					if (balls[2][0] == -1 && balls[4][0] == -1 && balls[5][0] != -1) { // 1번공이 존재할때
						tbx = balls[5][0];
						tby = balls[5][1];

						int hx = 0;
						int hy = 0;
						// 타겟공을 넣기 좋은 구멍 찾기
						// { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
						// 일직선상 라인 찾기
						if (tbx < 127 / 2 && tby < 127 / 2) { // 0,0
							hx = 0;
							hy = 0;
						}
						if (tbx >= 127 / 2 && tbx <= 127 + 127 / 2 && tby >= 127 / 2) { // 127,127
							hx = 127;
							hy = 127;
						}
						if (tbx > 127 + 127 / 2 && tby > 127 / 2) { // 254,127
							hx = 254;
							hy = 127;
						}
						if (tbx >= 127 / 2 && tbx >= 127 + 127 / 2 && tby <= 127 / 2) { // 127,0
							hx = 127;
							hy = 0;
						}

						if (tbx > 127 + 127 / 2 && tby < 127 / 2) { // 254,0
							hx = 254;
							hy = 0;
						}

						width = Math.abs(tbx - wbx);
						height = Math.abs(tby - wby);
						radian = Math.atan(width / height);
						if (height == 0)
							height = 1;
						double newRad = getRadian(wbx, wby, tbx, tby, radian);
						if (Math.abs(tby - hy) == 0)
							hy += 1;
						double hole = getRadian(tbx, tby, hx, hy, Math.atan((Math.abs(tbx - hx)) / Math.abs(tby - hy)));
						distance = Math.sqrt((width * width) + (height * height));

						if (newRad == hole) // 일직선
							angle = (float) ((180.0 / Math.PI) * newRad); // 그냥 치기
						else {
							if (wby > tby)
								angle = (float) ((180.0 / Math.PI) * newRad - 1);
							else {
								angle = (float) ((180.0 / Math.PI) * newRad + 1.1);
								System.out.println(1111);
							}
						}
						power = (float) distance;
					}
				}

				// You can clear Stage 1 with the pre-written code above.
				// Those will help you to figure out how to clear other Stages.
				// Good luck!!
				// ENd of Your Code
				//////////////////////////////

				// Play(Send Data)
				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}
			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	private static double getRadian(int wbx, int wby, int tbx, int tby, double radian) {
		if (tbx > wbx && tby > wby)
			radian = radian;
		if (tbx > wbx && tby < wby) {
			radian = Math.PI - radian;
		}
		if (tbx < wbx && tby < wby)
			radian = Math.PI + radian;
		if (tbx < wbx && tby > wby)
			radian = 2 * Math.PI - radian;

		return radian;
	}

}