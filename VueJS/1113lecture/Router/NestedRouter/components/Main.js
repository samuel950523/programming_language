export default {
    template: `
        <div>
            <h4>Main Component</h4>
            <p>안녕하세요, Vue Router 를 학습하고 있습니다.</p>
            <router-view></router-view>
            <router-link to="/main/child1">첫 번째</router-link>
            <router-link to="/main/child2">두 번째</router-link>
        </div>
    `,
};
