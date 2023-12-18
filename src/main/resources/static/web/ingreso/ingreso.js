Vue.createApp({
    data() {
        return {
            nombreUsuario: "",
            email: "",
            password: "",
            errorMsg: "",
            showSignUp: false,
            errorToast: null,
        };
    },
    methods: {
        signIn: function (event) {
            event.preventDefault();
            let config = {
                headers: {
                    'content-type': 'application/x-www-form-urlencoded'
                }
            };
            axios.post('/auth/signin', `email=${this.email}&password=${this.password}`, config)
                .then(response => window.location.href = "/static/index.html")
                .catch(() => {
                    this.errorMsg = "Sign in failed, check the information";
                    this.errorToast.show();
                });
        },
  
    },
    mounted: function () {
        this.errorToast = new bootstrap.Toast(document.getElementById('danger-toast'));
    }
}).mount('#app');
