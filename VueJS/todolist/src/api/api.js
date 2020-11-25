import axios from 'axios'

export const createTodo = (input) => {
    return new Promise((resolve) => {
        try {
            const result = axios.post(`http://127.0.0.1:8080/todo`,
                {
                    "content": input.content,
                    "createdAt": input.createdAt  // createdAt를 만들어두기 
                }
            );
            resolve(result);
        } catch (error) {
            resolve(false);
        }
    })
};

export const showTodolist = (params) => {
    return new Promise((resolve) => {
        try {
            const result = axios.get(`http://127.0.0.1:8080/todolist`, {
                params: params // 여기에 날짜를 넣는 것
            });
            resolve(result);
        } catch (error) {
            resolve(false);
        }
    })
};

export const editMemo = (id, memo) => {
    return new Promise((resolve) => {
        try {
            const result = axios.put(`http://127.0.0.1:8080/todo`, { "id": id, "content": memo });
            resolve(result);
        } catch (error) {
            resolve(false);
        }
    })
};

export const deleteMemo = (id) => {
    return new Promise((resolve) => {
        try {
            const result = axios.delete(`http://127.0.0.1:8080/todo/` + id);
            resolve(result);
        } catch (error) {
            resolve(false);
        }
    })
};
export const showWeather = (params) => {
    return new Promise((resolve) => {
        try {
            const result = axios.get(`http://127.0.0.1:8080/weather`, {
                params: params
            });
            resolve(result);
        } catch (error) {
            resolve(false);
        }
    })
};