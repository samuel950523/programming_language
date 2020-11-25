<template>
    <div>
        <h2>{{ getSidoCode }}</h2>
    </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
    computed: {
        ...mapGetters(["getSido"]),
        getSidoCode() {
            return this.$store.state.sido;
        },
    },
};
</script>