Ext.define('LSYS.view.Viewport', {
    extend: 'Ext.container.Viewport',
    layout: 'border',
    items: [
    {
         title:'菜单',
	 region:'west',
	 collapsible: true,
       animCollapse: true,
	 margins: '5 0 5 5',
	 width:225,
	 xtype: 'navigation'
    },{
	     region:'center',
         xtype: 'userlist',
           margins: '5 0 5 5'
    },{
  	  region:'east',
      xtype: 'panel',
      title:'统计及描述',
      margins: '5 5 5 5',
      layout:{
        type:'vbox',
        align:'stretch'
      },
      width:250,
      collapsible:true,
      split:true,
      items:[
       {
        xtype: 'panel',
        layout:'fit',
        title: '统计',
        tbar: [{
            text: '刷新数据',
            id:'reData'
        }],
        items:[{ xtype: 'listpie'}],
        flex:2
        },
       { 
        xtype: 'despanel',
        flex:4
      }]
 }]
});