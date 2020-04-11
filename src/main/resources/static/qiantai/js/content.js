/**
 *
 */

var vm = new Vue({
	el:'#content',
	data:{
		page:1,
		pageSize:9,
		total:100,
		maxPage:7,
		cateList:[],
		cateListfive:[],
		cateName:null,
		cateId:null,
		searchName:null,
		productList:null,
	},
	created:function(){
		this.categoryList();
		this.findAllfive();
		//this.pageHandler(1);
	},
	methods:{
		categoryList:function(){
			this.$http.post('/category/findAll',{emulateJSON:true}).then(function(res){
				this.cateList = res.body;

			},function(res){

			});
		},
		findAllfive:function(){
			this.$http.post('/category/findAllfive',{emulateJSON:true}).then(function(res){
				this.cateListfive = res.body;

			},function(res){

			});
		},
		product:function(){
			var options = {name:this.searchName,cid:this.cateId,page:this.page,rows:this.pageSize};
			this.$http.post('/product/findPage',options,{emulateJSON:true}).then(function(res){
				this.productList = res.body.rows;
				this.total = res.body.total;
			},function(res){

			});
		},
		pageHandler: function (page) {
			this.page = page;
			this.product();
		},
		cateNamedianji:function(data,id){
			this.cateName = data;
			this.cateId = id;
			this.pageHandler(1);
		},
		searchByName:function(){
			this.pageHandler(1);
		},

	}
});

