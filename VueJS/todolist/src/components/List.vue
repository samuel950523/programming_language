<template>

        <v-flex xs12 sm8 md8 lg6 x12>

      <v-card
      elevation="1" outlined shaped tile
       class="pa-3 mb-3" 
       background-color="amber lighten-4"
       color="teal lighten-5"
       :class="{'done': list.status === 'done'}"
       v-for="(list, index) in todoList"
       :key="index"
       id="cardstyle"
      >
      <div @mouseover="mousecheck" class="test___">
        <p>{{list.memo}}</p>
        <!-- 만들기 -->

       </div>
    
       <div id= "sample" v-if="key" >
        <v-btn 
        v-if="list.status === 'created'"
        @click="$emit('statuscontrol',index,'done')"
        fab flat small color="green"
        >
        <i class="fas fa-check"></i></v-btn>
       
        <!-- 부활 -->
        <v-btn
        v-else
        @click="$emit('statuscontrol',index,'created')"
         fab flat small color="blue"
         >
         <i class="fas fa-redo-alt"></i></v-btn>
        
        <v-btn
          @click="$emit('listdelete',index)"
         fab flat small color="red">
         <i class="fas fa-trash-alt"></i></v-btn>
        
        <!--수정을 위한 index값 찾기 -->
    
         <v-btn
           @click="listEdit(list.memo, index)" 
           v-if="list.status==='created'"
           fab flat small color="yellow">
           <i class="fas fa-edit"></i>
           </v-btn>    
    </div>
     </v-card>
   </v-flex>
    
</template>

<script>
import { eventBus } from "../main"
export default {
    props: ["todoList"],
    data(){
      return {
       key : true
      }
    },
    methods:{
        listEdit(memo, index){
         eventBus.listEdit(memo, index)
        },
        mousecheck : function(){
          this.key = !this.key
        }
    },
   
}


</script>

<style scoped>
.done{
    background-color: rgba(0,0,0,0.1);
}
.done p {
    text-decoration: line-through;
    color: rgba(0, 0,0, 0.5);
}
#test7 {
      display:flex; align-items:center;
    }

#sample {
     margin-left: 500px;
     margin-top: -50px;
    }

  

</style>