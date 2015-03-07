var TableEditable = function () {

    return {

        //main function to initiate the module
        init: function () {
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                console.log(aData);

             //   for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    
                    oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                    oTable.fnUpdate(jqInputs[1].value,nRow,1,false);
                     oTable.fnUpdate(jqInputs[2].value,nRow,2,false);
                      oTable.fnUpdate(jqInputs[3].value,nRow,3,false);
                       oTable.fnUpdate(jqInputs[4].value,nRow,4,false);
                    oTable.fnUpdate('<a class="edit" href="">Edit</a>',nRow,5,false);
                    oTable.fnUpdate('<a class="delete" href="">Delete</a>',nRow,6,false);
               // }

                oTable.fnDraw();
            }

            function editRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                console.log(aData);
                var jqTds = $('>td', nRow);
                //jqTds[0].innerHTML = '<input type="text" class="m-wrap small" value="' + aData[0] + '">';
                jqTds[0].innerHTML = '<input type="text" class="m-wrap small" value="' + aData.user_email + '">';
                jqTds[1].innerHTML = '<input type="text" class="m-wrap small" value="' + aData.user_name + '">';
                jqTds[2].innerHTML = '<input type="text" class="m-wrap small" value="' + aData.user_password + '">';
                jqTds[3].innerHTML = '<input type="text" class="m-wrap small" value="' + aData.nickname.nick_name + '">';
                jqTds[4].innerHTML = '<input type="text" class="m-wrap small" value="' + aData.rank.rank_name + '">';
                jqTds[5].innerHTML = '<a class="edit" href="">Save</a>';
                jqTds[6].innerHTML = '<a class="cancel" href="">Cancel</a>';
                
            }

            function saveRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                console.log(jqInputs);
                console.log(jqInputs[0]);
                //oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                   oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                    oTable.fnUpdate(jqInputs[1].value,nRow,1,false);
                     oTable.fnUpdate(jqInputs[2].value,nRow,2,false);
                      oTable.fnUpdate(jqInputs[3].value,nRow,3,false);
                       oTable.fnUpdate(jqInputs[4].value,nRow,4,false);

                    oTable.fnUpdate('<a class="edit" href="">Edit</a>',nRow,5,false);
                    oTable.fnUpdate('<a class="delete" href="">Delete</a>',nRow,6,false);
                /*oTable.fnUpdate(jqInputs[0].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 3, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 4, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 5, false);
                oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 6, false);*/
                
                 var aData = oTable.fnGetData(nRow);
                 console.log(aData);
                $.ajax({ 
                    url: "/SourceManage/px/Px_UserServlet?c=u", 
                   
                   dataType:"json", 
                    data:aData,
                    contentType:"application/json;charset=utf-8",
                    context: document.body, 
                    success: function(){
                        alert('Hello');
                 }});
                oTable.fnDraw();
            }

            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate(jqInputs[4].value, nRow, 4, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 5, false);
                oTable.fnDraw();
            }

            var oTable = $('#sample_editable_1').dataTable({
              /* "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],*/
                // set the initial value
                
              
              
               "oLanguage": {
                    "sLengthMenu": "_MENU_ records per page",
                    "oPaginate": {
                        "sPrevious": "Prev",
                        "sNext": "Next"
                    }
                },
                "iDisplayLength": 5,
                 "sPaginationType": "bootstrap",
                   "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
                
              
                    "sAjaxSource":"/SourceManage/px/Px_UserServlet?c=q",
             "aoColumns": [  
                    
                 
                    { "mDataProp": "user_email" },  
                       {  "mDataProp": "user_password" },  
                        {  "mDataProp": "user_name" },
                        {  "mDataProp": "nickname.nick_name" },
                        {  "mDataProp": "rank.rank_name" },
                    //"sTitle":"extn", 
                    
                    {"sTitle":"edit","fnRender": function (obj) {
    return '<a class=\"edit\" href=\"javascript:;\">Edit</a>';}},
    {"sTitle":"delete","fnRender": function (obj) {
    return '<a class=\"delete\" href=\"javascript:;\">delete</a>';}}
                ],
                "aoColumnDefs" : [ {

        sDefaultContent : '',

        aTargets : [ '_all' ]
                }]
      
       
             /*   "aoColumnDefs": [{
                        'bSortable': false,
                        'aTargets': [0]
                    }
                ]*/
            });

         //   jQuery('#sample_editable_1_wrapper .dataTables_filter input').addClass("m-wrap medium"); // modify table search input
          //  jQuery('#sample_editable_1_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
            //jQuery('#sample_editable_1_wrapper .dataTables_length select').select2({
           //     showSearchInput : false //hide search box with special css class
           // }); // initialzie select2 dropdown

            var nEditing = null;
          /*  $('#select_course_id').select(function(){
               
            });*/
           
            $('#sample_editable_1_new').click(function (e) {
                e.preventDefault();
                //alert('change log 2');
                var aiNew = oTable.fnAddData([{2: "<a class='edit' href='javascript:;'>Edit</a>",3: "<a class='delete' href='javascript:;'>delete</a>",course_id:"" ,course_info: "",course_jieshu: "",course_name: "",course_term: "",course_week: ""}]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
            });

            $('#sample_editable_1 a.delete').live('click', function (e) {
                e.preventDefault();

                if (confirm("Are you sure to delete this row ?") == false) {
                    return;
                }

                var nRow = $(this).parents('tr')[0];
               
                var aData=oTable.fnGetData(nRow);
                console.log(nRow);
                console.log(aData);
                 $.ajax({ 
                    url: "/SourceManage/px/Px_UserServlet?c=d", 
                   
                    dataType:"json", 
                    data:aData,
                    contentType:"application/json;charset=utf-8",
                    context: document.body, 
                    success: function(data,success){
                        alert('success');
                 }});
                oTable.fnDeleteRow(nRow);
                
            });

            $('#sample_editable_1 a.cancel').live('click', function (e) {
                e.preventDefault();
                if ($(this).attr("data-mode") == "new") {
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });

            $('#sample_editable_1 a.edit').live('click', function (e) {
                e.preventDefault();

                /* Get the row as a parent of the link that was clicked on */
                var nRow = $(this).parents('tr')[0];

                if (nEditing !== null && nEditing != nRow) {
                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == "Save") {
                    /* Editing this row and want to save it */
                    saveRow(oTable, nEditing);
                    nEditing = null;
                    alert("Updated! Do not forget to do some ajax to sync with backend :)");
                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });
        }

    };

}();