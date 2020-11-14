export default {
    template: `
    <div>
    <div class="form-group">
      <label for="userId">ID</label>
      <input type="text" class="form-control" id="userId" ref="userId" placeholder="아이디를 입력하세요" v-model="userId">
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" ref="password" placeholder="비밀번호를 입력하세요" v-model="password">
    </div>
    <div class="text-center">
      <button class="btn btn-primary" @click="login">Login</button>
    </div>
  </div>
    `,
    data: {
        userId: '',
        password: '',
    },
    methods: {
        login() {
            alert(this.userId + '/' + this.password);
        },
    },
};
