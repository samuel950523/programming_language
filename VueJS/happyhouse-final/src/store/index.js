import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        lat: 37.5743822,
        lng: 126.9688505,
        dongChange: '',
        positions: [],
        aptList: [],
        aptChange: ''
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
    },
});