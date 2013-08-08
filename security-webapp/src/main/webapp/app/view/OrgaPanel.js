/*
 * File: app/view/OrgaPanel.js
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

Ext.define('Security.view.OrgaPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.orgapanel',

    requires: [
        'Security.view.OrgaTree'
    ],

    layout: {
        align: 'stretch',
        type: 'hbox'
    },
    bodyPadding: 1,
    title: '组织机构管理',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'orgatree',
                    width: 334
                },
                {
                    xtype: 'splitter'
                },
                {
                    xtype: 'gridpanel',
                    flex: 1,
                    title: '用户列表',
                    columnLines: true,
                    store: 'OrgaUser',
                    columns: [
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'username',
                            text: '用户名'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'loginName',
                            text: '登录名'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'password',
                            text: '密码'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'sex',
                            text: '性别'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'userCard',
                            text: '用户证号'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'phone',
                            text: '电话'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'fax',
                            text: '传真',
                            flex: 1
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});