#工程实践前端文档总结

##course 模块的实现

一共涉及三个文件  Px_CourseServlet px/index.html  px/media/js/index-table.js 

course表结构：

![f](https://easyforgood.github.io/temp/db.png)

servlet代码：

//Px_courseServlet.java

        //设置request类型和response类型  返回json数据
        request.setCharacterEncoding("UTF-8"); 
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("application/json;charset=UTF-8");
        //后面使用out.println(json)将json输出
    	PrintWriter out = response.getWriter();
        String cmd=request.getParameter("c");
        //输出的json对象
        JSONObject json=new JSONObject();

逻辑部分：
            
            //查询
            if(cmd.equals("q")){
                //查询 返回结构为list类型
    			List<Px_Course> list=dao.queryAll();
                //将list转换成json类型
				JSONArray array=JSONArray.fromObject(list);
                //json的格式 {sEcho:"",iTotalRecords:"",iTotalDisplayRecords:"",aaData:""}
                //sEcho = iTotalRecords =iTotalDisplayRecords 都设置为list的大小 前端才能读取全部数据
				json.put("sEcho", list.size());
				json.put("iTotalRecords",list.size());
				json.put("iTotalDisplayRecords",list.size());
				json.put("aaData",array);
			}
最后 

        out.println(json);//输出json到前端
        
修改操作：request.getParameter 正常获取参数

            //修改
            if(cmd.equals("u")){
                String aaData=request.getParameter("aData");
				String course_id=request.getParameter("course_id");
				String course_name=request.getParameter("course_name");
				String course_week=request.getParameter("course_week");
				String course_jieshu=request.getParameter("course_jieshu");
				String course_term=request.getParameter("course_term");
				String course_info=request.getParameter("course_info");
				course_name=URLDecoder.decode(course_name, "utf-8");
                
				Px_Course course=new Px_Course();
				course.setCourse_info(course_info);
				course.setCourse_jieshu(course_jieshu);
				course.setCourse_name(course_name);
				course.setCourse_term(course_term);
				course.setCourse_week(course_week);
                Px_Course course=new Px_Course();
    			course.setCourse_info(course_info);
				course.setCourse_jieshu(course_jieshu);
				course.setCourse_name(course_name);
				course.setCourse_term(course_term);
				course.setCourse_week(course_week);
                boolean result=dao.updateCourse(course);
            }



前端代码：

###修改index.html 

找到 table

    <table class="table table-striped table-hover table-bordered" id="sample_editable_1">
    


修改表结构

     <thead>
            <tr>
                <th style=" visibility:hidden;">course_id</th>
                <th>课程名</th>
                <th>课程学期</th>
                <th>课程信息</th>
                <th>课程结束时间</th>
                <th>课程周数</th>
                <th>Edit</th>
    			<th>Delete</th>
            </tr>
        </thead>
        
修改html中引用的js文件：index.html的最下方 

    <script src="media/js/index-table.js"></script>    
    
---
    
###修改index-table.js

**/////////////// 结构**

找到 

     var oTable = $('#sample_editable_1').dataTable({
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
                
              
                    "sAjaxSource":"/SourceManage/px/Px_CourseServlet?c=q",
             "aoColumns": [  
                    { "mDataProp": "course_id" , "sClass" : "hidden",},  
                    {  "mDataProp": "course_name" },  
                    { "mDataProp": "course_term" },  
                    {  "mDataProp": "course_info" },  
                    { "mDataProp": "course_jieshu" },
                    {"sTitle":"课程周数","mDataProp": "course_week" }, //"sTitle":"extn", 
                    
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

需要修改的部分为：
    
        //数据源对应的servlet
        "sAjaxSource":"/SourceManage/px/Px_CourseServlet?c=q",
        
        //修改行格式和 之前修改的table对应  mDataProp和json的格式中的属性名称对应
        "aoColumns": [  
                    { "mDataProp": "course_id" , "sClass" : "hidden",},  
                    {  "mDataProp": "course_name" },  
                    { "mDataProp": "course_term" },  
                    {  "mDataProp": "course_info" },  
                    { "mDataProp": "course_jieshu" },
                    {"sTitle":"课程周数","mDataProp": "course_week" },



**/////增删改查的修改**

       init: function () {
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                console.log(aData);

             //   for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData.course_name, nRow, 1, false);
                    oTable.fnUpdate(aData.course_term,nRow,2,false);
                    oTable.fnUpdate(aData.course_info,nRow,3,false);
                    oTable.fnUpdate(aData.course_jieshu,nRow,4,false);
                    oTable.fnUpdate(aData.course_week,nRow,5,false);
                    oTable.fnUpdate('<a class="edit" href="">Edit</a>',nRow,6,false);
                    oTable.fnUpdate('<a class="delete" href="">Delete</a>',nRow,7,false);
               // }

                oTable.fnDraw();
            }
或者    

                jqTds[1].innerHTML = '<input type="text" class="m-wrap small" value="' + aData.course_name + '">';
                jqTds[2].innerHTML = '<input type="text" class="m-wrap small" value="' + aData.course_term + '">';
                jqTds[3].innerHTML = '<input type="text" class="m-wrap small" value="' + aData.course_info + '">';
                jqTds[4].innerHTML = '<input type="text" class="m-wrap small" value="' + aData.course_jieshu + '">';
                  jqTds[5].innerHTML = '<input type="text" class="m-wrap small" value="' + aData.course_week + '">';
                //    jqTds[5].innerHTML = '<input type="text" class="m-wrap small" value="' + aData[5] + '">';
                jqTds[6].innerHTML = '<a class="edit" href="">Save</a>';
               jqTds[7].innerHTML = '<a class="cancel" href="">Cancel</a>';
               
将其中的格式改成 和 table对应的结构

    jqTds[6].innerHTML = '<a class="edit" href="">Save</a>';
    jqTds[7].innerHTML = '<a class="cancel" href="">Cancel</a>';
    
    oTable.fnUpdate('<a class="edit" href="">Edit</a>',nRow,6,false);
    oTable.fnUpdate('<a class="delete" href="">Delete</a>',nRow,7,false);
    
edit和delete为最后两行 所以如果只有3列（这里是5列），需要改为4、5

数据的保存在saveRow中：

      function saveRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                console.log(jqInputs);
                console.log(jqInputs[0]);
                
                   oTable.fnUpdate(jqInputs[0].value, nRow, 1, false);
                    oTable.fnUpdate(jqInputs[1].value,nRow,2,false);
                    oTable.fnUpdate(jqInputs[2].value,nRow,3,false);
                    oTable.fnUpdate(jqInputs[3].value,nRow,4,false);
                    oTable.fnUpdate(jqInputs[4].value,nRow,5,false);
                    oTable.fnUpdate('<a class="edit" href="">Edit</a>',nRow,6,false);
                    oTable.fnUpdate('<a class="delete" href="">Delete</a>',nRow,7,false);
              
                
                 var aData = oTable.fnGetData(nRow);
                 console.log(aData);
                $.ajax({ 
                    url: "/SourceManage/px/Px_CourseServlet?c=u", 
                   
                   dataType:"json", 
                    data:aData,
                    contentType:"application/json;charset=utf-8",
                    context: document.body, 
                    success: function(){
                        alert('Hello');
                 }});
                oTable.fnDraw();
            }

除了结构部分：

        oTable.fnUpdate(jqInputs[0].value, nRow, 1, false);
        oTable.fnUpdate(jqInputs[1].value,nRow,2,false);
        oTable.fnUpdate(jqInputs[2].value,nRow,3,false);
        oTable.fnUpdate(jqInputs[3].value,nRow,4,false);
        oTable.fnUpdate(jqInputs[4].value,nRow,5,false);
        oTable.fnUpdate('<a class="edit" href="">Edit</a>',nRow,6,false);
        oTable.fnUpdate('<a class="delete" href="">Delete</a>',nRow,7,false);
还需要修改数据提交的部分：

     $.ajax({ 
                    url: "/SourceManage/px/Px_CourseServlet?c=u", 
                   
                   dataType:"json", 
                    data:aData,
                    contentType:"application/json;charset=utf-8",
                    context: document.body, 
                    success: function(){
                        alert('Hello');
                 }});

主要是修改url即可 改成需要请求的地址


