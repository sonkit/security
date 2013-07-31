Ext.example = function(){
    var msgCt;

    function createBox(t, s){
       return '<div class="msg"><h3>' + t + '</h3><p>' + s + '</p></div>';
    }
    return {
        msg : function(title, format){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
            }
            var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
            var m = Ext.DomHelper.append(msgCt, createBox(title, s), true);
            m.hide();
            m.slideIn('t').ghost("t", { delay: 1500, remove: true});
        },

        init : function(){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
            }
        }
    };
}();

addTab = function(args) {
    
    var controller = args.controller,
        view = args.view,
        app = Security.getApplication(),
        tabs = Ext.ComponentQuery.query('viewport > tabpanel').pop(),
        tab = tabs.child(view);
    
    if (!tab) {
        app.getController(controller);
        tab = tabs.add(Ext.widget(view, {closable: true}));
    }

    tabs.setActiveTab(tab);
};

Ext.Ajax.on('requestexception', function(conn, response, options, eOpts) {
    Ext.example.msg('系统异常', response.responseText);
});