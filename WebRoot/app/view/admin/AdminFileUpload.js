Ext.define('LSYS.view.admin.AdminFileUpload', {
    extend: 'Ext.window.Window',
    alias : 'widget.adminfileupload',
    layout: 'fit',
    autoShow: true,
    title: '文件上传',
    width: 800,
    height:500,
    modal : true,
    items:[{
        xtype:'form',
        bodyPadding: '10 10 0',
        defaults: {
            anchor: '100%',
            allowBlank: false,
            msgTarget: 'side',
            labelWidth: 50
        },

        items: [{
            xtype: 'textfield',
            fieldLabel: '文件名'
        },{
            xtype: 'filefield',
            id: 'form-file',
            emptyText: '选择一个文件',
            fieldLabel: '文件',
            name: 'file-path',
            buttonText: '',
            buttonConfig: {
                iconCls: 'upload-icon'
            }
        },{
            xtype: 'textareafield',
            name: 'reportDescription',
            fieldLabel: '派单描述',
            value: '请填写相关派单描述'
        }],

        buttons: [{
            text: '保存',
            handler: function(){
                var form = this.up('form').getForm();
                if(form.isValid()){
                    form.submit({
                        url: 'file-upload.php',
                        waitMsg: '正在上传...',
                        success: function(fp, o) {
                            msg('Success', tpl.apply(o.result));
                        }
                    });
                }
            }
        },{
            text: '重置',
            handler: function() {
                this.up('form').getForm().reset();
            }
        }]
    }]
});
