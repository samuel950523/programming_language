<template>
    <div class="container pt-3">
        <h5>Tell Me ...</h5>
        <div id=divCKEditor></div>
        <button @click="sendTellMe" class="btn btn-primary mt-2">Send</button>
    </div>
</template>

<script>
    import Vue from 'vue';
    import CKEditor from '@ckeditor/ckeditor5-vue';
    import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
    Vue.use( CKEditor );

  export default {
    name: 'TellMe',
    data() {
        return {
            CKEditor : ''
        }
    },
    methods: {
        sendTellMe(){
            let message = this.CKEditor.getData();
            alert(message);
        }
    },
    mounted() {
        ClassicEditor
        .create( document.querySelector( '#divCKEditor' ) ) // .create( $('#divEditorInsert')[0] )
        .then( editor => {
          this.CKEditor = editor;
          } )
        .catch( err => {
            console.error( err.stack );
        } );
    }
  }
</script>

<style>
  /* move <link rel="stylesheet" href="..." from XXX.html */
  .ck-editor__editable {
      min-height: 300px;
  }
</style>