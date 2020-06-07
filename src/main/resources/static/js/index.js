
var place = {

    search : function(){

        var frm = document.searchForm;

        if($.trim(frm.searchWord.value) == ""){
            alert("Please enter a search work.");
            frm.searchWord.focus();
            return false;

        } else {

        var url = "http://localhost:8081/place";
        var data = $("form[name=searchForm]").serialize();

        $.ajax({
            type:"GET",
            url: "http://localhost:8081/place",
            data: data,
            dataType : 'JSON',
            success: function(result){
                place.makeList(result);
            },
            error : function( jqXHR, textStatus, errorThrown ) {

                console.log(jqXHR.status );

                console.log( jqXHR.statusText );

                console.log( jqXHR.responseText );

                console.log( jqXHR.readyState );

            }
         });//ajax end
       }
    }
}