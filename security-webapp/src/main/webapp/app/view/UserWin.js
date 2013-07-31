/*
 * File: app/view/UserWin.js
 *
 * This file was generated by Sencha Architect version 2.2.2.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('Security.view.UserWin', {
    extend: 'Ext.window.Window',
    alias: 'widget.userwin',

    width: 350,
    constrain: true,
    layout: {
        type: 'fit'
    },
    constrainHeader: true,
    title: '用户信息',
    modal: true,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    bodyPadding: 10,
                    fieldDefaults: {
                        labelWidth: 70
                    },
                    items: [
                        {
                            xtype: 'hiddenfield',
                            name: 'id'
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            fieldLabel: '用户名',
                            name: 'username'
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            fieldLabel: '登录名',
                            name: 'loginName'
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            fieldLabel: '密码',
                            name: 'password'
                        },
                        {
                            xtype: 'combobox',
                            anchor: '100%',
                            fieldLabel: '性别',
                            name: 'sex',
                            value: '男',
                            editable: false,
                            queryMode: 'local',
                            store: [
                                '男',
                                '女'
                            ]
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            fieldLabel: '用户证号',
                            name: 'userCard'
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            fieldLabel: '电话',
                            name: 'phone'
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            fieldLabel: '传真',
                            name: 'fax'
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            fieldLabel: '所属组织',
                            name: 'orga.id'
                        }
                    ]
                }
            ],
            dockedItems: [
                {
                    xtype: 'toolbar',
                    dock: 'bottom',
                    items: [
                        {
                            xtype: 'button',
                            text: '保存'
                        },
                        {
                            xtype: 'button',
                            text: '关闭'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});