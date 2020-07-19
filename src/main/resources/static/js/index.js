var overlay;


var place = {

    search : function(){

        var frm = document.searchForm;
        var buttonClick = frm.buttonClick.value;

        //If keyword is null
        if($.trim(frm.keywordNm.value) == ""){
            alert("Please enter a search work.");
            frm.keywordNm.focus();
            return false;

        } else {

        var url = "/place";
        var data = $("form[name=searchForm]").serialize();

        $.ajax({
            type:"GET",
            url: "http://localhost:9091/place",
            data: data,
            dataType : 'JSON',

            success: function(result){
                result.buttonClick = buttonClick;
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
    },

    makeList : function(data){
//
//            jQuery.ajaxSettings.traditional = true;

             $.ajax({
                 type:"POST",
                 url: "/makeList",
                 data : JSON.stringify(data),
                 contentType: 'application/json',

                success: function(result){
                    refreshMemList();    //reload

                }, //success
                error : function( jqXHR, textStatus, errorThrown ) {

                    console.log(jqXHR.status );

                    console.log( jqXHR.statusText );

                    console.log( jqXHR.responseText );

                    console.log( jqXHR.readyState );

                } //error
             });//ajax end
        },


    list : function(currentPage, keywordNm) {

        var currentPage = currentPage;

        var frm = document.searchForm;
            frm.currentPage.value =parseInt(currentPage);
            frm.keywordNm.value = keywordNm;

        var data = $("form[name=searchForm]").serialize();

        $.ajax({
            type: "GET",
            url: "http://localhost:9091/place",
            data: data,
            dataType: 'JSON',
            success: function (res) {
                place.makeList(res);
            },
            error : function( jqXHR, textStatus, errorThrown ) {
                console.log(jqXHR.status );
                console.log( jqXHR.statusText );
                console.log( jqXHR.responseText );
                console.log( jqXHR.readyState );

            }
        });
    }

}

//Reload the indexPage
function refreshMemList(){
    location.reload();
}

