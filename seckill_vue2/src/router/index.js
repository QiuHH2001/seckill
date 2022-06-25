import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)



const routes = [{
        meta: {
            requireAuth: true
        },
        path: '/',
        redirect: '/product',
        name: 'home',
        component: HomeView,
        children: [{
                path: 'product',
                name: 'product',
                meta: {
                    requireAuth: true
                },
                component: () =>
                    import ("../components/SeckillProduct.vue")
            },
            {
                path: 'order',
                name: 'order',
                meta: {
                    requireAuth: true
                },
                component: () =>
                    import ("../components/Order.vue")
            },
            {
                path: 'person',
                name: 'person',
                meta: {
                    requireAuth: true
                },
                component: () =>
                    import ("../components/Person.vue")
            }
        ]

    },
    {
        path: '/about',
        name: 'about',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/AboutView.vue')
    },
    {
        path: '/login',
        name: 'login',
        component: () =>
            import ('../views/login.vue')
    },
    {
        path: '/register',
        name: 'register',
        component: () =>
            import ('../views/register.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

router.beforeEach((to, from, next) => {
    if (to.meta.requireAuth) {
        let user = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
        if (user) {
            next()
        } else {
            next({
                path: "/login",
                query: { redirect: to.path }
            })
        }
    } else {
        next()
    }
})

export default router