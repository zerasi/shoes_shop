/**
 *
 */

var vm = new Vue({
	el:'#fixed',
	data:{
		username:null,
	},
	created:function(){
		this.zhanshi();
	},
	methods:{
		zhanshi:function(){
			this.$http.post('/user/zhanshi',{emulateJSON:true}).then(function(res){
				if(res.body.username == null){

				}else{
					this.username = res.body.username;
				}

			},function(res){

			});
		},
		logout:function(){
			this.$http.post('/user/logout',{emulateJSON:true}).then(function(res){
				location.href="login.html";
			},function(res){

			});
		}

	}
});

