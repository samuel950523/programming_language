export default{
    template:`
    <div class="container pt-3">
        <h5>Tell Me ...</h5>
        <div id=divCKEditor></div>
        <button @click="sendTellMe" class="btn btn-primary mt-2">Send</button>
    </div>
    `,
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