import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        sido: 0,
        gugun: 0,
        dong: 0,
    },
    mutations: {
        sidoVal(state, payload) {
            state.sido = payload.val;
        },
    },
    getters: {
        getSido(state) {
            return state.sido;
        },
    },
});