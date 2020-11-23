<template>
    <div>
        <v-card
            class="pa-3 mb-3"
            :class="{ done: list.status === 'done' }"
            v-for="(list, index) in todoList"
            :key="index"
        >
            <p>{{ list.memo }}</p>
            <!-- 만들기 -->
            <v-btn
                v-if="list.status === 'created'"
                @click="$emit('statusControl', index, 'done')"
                fab
                flat
                small
                color="green"
            >
                <i class="fas fa-check"></i
            ></v-btn>

            <!-- 부활 -->
            <v-btn
                v-else
                @click="$emit('statusControl', index, 'created')"
                fab
                flat
                small
                color="blue"
            >
                <i class="fas fa-redo-alt"></i
            ></v-btn>

            <v-btn
                @click="$emit('listDelete', index)"
                fab
                flat
                small
                color="red"
            >
                <i class="fas fa-trash-alt"></i
            ></v-btn>

            <!--수정을 위한 index값 찾기 -->
            <v-btn
                @click="listEdit(list.memo, index)"
                v-if="list.status === 'created'"
                fab
                flat
                small
                color="yellow"
            >
                <i class="fas fa-edit"></i>
            </v-btn>
        </v-card>
    </div>
</template>

<script>
import { eventBus } from "../main";
export default {
    props: ["todoList"],
    methods: {
        listEdit(memo, index) {
            eventBus.listEdit(memo, index);
        },
    },
};
</script>

<style scoped>
.done {
    background-color: rgba(0, 0, 0, 0.1);
}
.done p {
    text-decoration: line-through;
    color: rgba(0, 0, 0, 0.5);
}
</style>