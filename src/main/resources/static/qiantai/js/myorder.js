/**
 *
 */

var vm = new Vue({
	el:'#myorder',
	data:{
		orderList:[],
	},
	created:function(){
		this.myorder();
	},
	methods:{
		myorder:function(){
			this.$http.post('/custOrder/myorder',{emulateJSON:true}).then(function(res){
				this.orderList = res.body;
			},function(res){

			});
		},
		pay:function(id){
			this.$http.post('/custOrder/pay',{id:id},{emulateJSON:true}).then(function(res){
				if(res.body.success){
					alert("yes")
					location.reload();
				}
			},function(res){

			});
		},
		over:function(id){
			this.$http.post('/custOrder/over',{id:id},{emulateJSON:true}).then(function(res){
				if(res.body.success){
					alert("yes");
					location.reload();
				}
			},function(res){

			});
		}

	}
});

