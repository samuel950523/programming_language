import axios from 'axios'

export const createNotice = (title, content) => {
    return new Promise((resolve) => {
        try {
            const result = axios.post(`http://127.0.0.1:8080/notice`,
                {
                    "title": title,
                    "content": content,
                }
            );
            resolve(result);
        } catch (error) {
            resolve(false);
        }
    })
};

export const showNotice = () => {
    return new Promise((resolve) => {
        try {
            const result = axios.get(`http://127.0.0.1:8080/noticelist`);
            resolve(result);
        } catch (error) {
            resolve(false);
        }
    })
};

export const editNotice = (id, title, content) => {
    return new Promise((resolve) => {
        try {
            const result = axios.put(`http://127.0.0.1:8080/notice`, { "id": id, "title": title, "content": content });
            resolve(result);
        } catch (error) {
            resolve(false);
        }
    })
};

export const deleteNotice = (id) => {
    return new Promise((resolve) => {
        try {
            const result = axios.delete(`http://127.0.0.1:8080/notice/` + id);
            resolve(result);
        } catch (error) {
            resolve(false);
        }
    })
};