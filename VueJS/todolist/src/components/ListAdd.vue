<template>
<v-flex  xs6 sm8 md8 lg6 x12>
    <div id = "test7">
   <!-- 텍스트 필드 -->
   <v-textarea id = "test"
    v-model="memo"
    label = "========= ( ღ'ᴗ'ღ )  할 일을 추가해보세요  ( ღ'ᴗ'ღ ) ========="
    background-color="amber lighten-4"
    color="orange orange-darken-4"
   >
   </v-textarea>
    </div>

   <v-btn rounded class="pink white--text" v-if="mode === 'add'" @click="listAdd" color="orange">할 일 추가( ღ'ᴗ'ღ ) </v-btn>
   <v-btn rounded class="pink white--text" v-else @click="listEdit"  color="green">할 일 수정하기( ღ'ᴗ'ღ ) </v-btn>
   
</v-flex>    
</template>

<script>
import {eventBus} from "../main"
export default {                    
    data(){
        return {
            memo : null,
            index : null,
            mode: "add",
            createdAt: null
       }

    },
    created(){
        eventBus.$on('listEdit', (memo,index) => {
            this.memo = memo
            this.index = index
            this.mode = "edit"
        })
    },
    methods: {
        listAdd(){
            if(this.memo == null){
                alert('할 일을 입력해주세요 ')
            }
            else{
                this.$emit("listAdd",this.memo)
                this.memo = null
                this.mode = 'add'
            }
        },
        listEdit(){
             if(this.memo == null){
                alert('할 일을 입력해주세요 ')
            }
            else{
                this.$emit("listEdit",this.memo, this.index)
                this.memo = null
                this.mode = "add"
            }
        }
    }
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap');
  #test {
    width : 30%;
    font-family: 'Nanum Gothic Coding', monospace;
    margin-top: 10px;
    font-size: 5px;
    }
</style>