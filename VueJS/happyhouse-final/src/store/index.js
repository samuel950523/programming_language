import Vue from 'vue';
import Vuex from 'vuex';
import axios from "axios";

Vue.use(Vuex);
// const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default new Vuex.Store({
    state: {
        lat: 37.5743822,
        lng: 126.9688505,
        dongChange: '',
        positions: [],
        aptList: [],
        aptChange: '',
        slicedList: [],
        accessToken: null,
        userName: "",
        userEmail: "",
    },
    mutations: {
        latVal(state, payload) {
            state.lat = payload.lat;
        },
        lngVal(state, payload) {
            state.lng = payload.lng;
        },
        isDongChange(state, payload) {
            state.dongChange = payload.dongChange;
        },
        isAptChange(state, payload) {
            state.aptChange = payload.aptChange;
        },
        positions(state, payload) {
            state.positions = payload.positions;
        },
        aptList(state, payload) {
            state.aptList = payload.aptList;
        },
        slicedList(state, payload) {
            state.slicedList = payload.slicedList;
        },
        LOGIN(state, payload) {
            state.accessToken = payload["auth-token"];
            state.userName = payload["user-name"];
            state.userEmail = payload["user-email"];
        },
        LOGOUT(state) {
            state.accessToken = null;
            state.userName = "";
            state.userEmail = "";
        }
    },
    getters: {
        messageComputed(state) {
            return state.lat;
        },
        positions(state) {
            return state.positions;
        },
        getAptList(state) {
            return state.aptList;
        },
        getLat(state) {
            return state.lat;
        },
        getLng(state) {
            return state.lng;
        },
        getDongChange(state) {
            return state.dongChange;
        },
        getAptChange(state) {
            return state.aptChange;
        },
        getSlicedList(state) {
            return state.slicedList;
        },
        getAccessToken(state) {
            return state.accessToken;
        },
        getUserName(state) {
            return state.userName;
        },
        getUserEmail(state) {
            return state.userEmail;
        },
    },
    actions: {
        LOGIN(context, user) {
            console.log(user)
            return axios
                .post(`http://127.0.0.1:8080/user/confirm/login`, user)
                .then((response) => {
                    context.commit("LOGIN", response.data);
                    axios.defaults.headers.common[
                        "auth-token"
                    ] = `${response.data["auth-token"]}`;
                });
        },
        LOGOUT(context) {
            context.commit("LOGOUT");
            axios.defaults.headers.common["auth-token"] = undefined;
        }
    },
});