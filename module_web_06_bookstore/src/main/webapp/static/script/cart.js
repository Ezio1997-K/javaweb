window.onload = function () {
    var vue = new Vue({
        el: "#cart_div",
        data: {
            cart: {}
        },
        methods: {
            getCart: function () {
                axios({
                    method: "POST",
                    url: "cart.do",
                    params: {
                        operate: "cartInfo"
                    }
                }).then(function (value) {
                    vue.cart = value.data
                }).catch(function (value) {
                })
            },
            editCart:function(cartItemId , buyCount){
                axios({
                    method:"POST",
                    url:"cart.do",
                    params:{
                        operate:'editCart',
                        cartItemId:cartItemId,
                        buyCount:buyCount
                    }
                })
                    .then(function (value) {
                        vue.getCart();
                    })
                    .catch(function (reason) {  });
            }
        },
        mounted: function () {
            this.getCart()
        }

    });
}