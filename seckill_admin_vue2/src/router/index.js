import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [{
        meta: {
            requireAuth: true
        },
        path: '/',
        name: 'home',
        redirect: '/setting',
        component: HomeView,
        children: [{
                path: 'setting',
                name: 'setting',
                meta: {
                    requireAuth: true
                },
                component: () =>
                    import ("../components/Setting.vue")
            },
            {
                path: 'situation',
                name: 'situation',
                meta: {
                    requireAuth: true
                },
                component: () =>
                    import ("../components/Situation.vue")
            }
        ]
    },
    {
        path: '/login',
        name: 'login',
        component: () =>
            import ('../views/Login.vue')
    },
    {
        path: '/about',
        name: 'about',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/AboutView.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

// router.beforeEach((to, from, next) => {
//     if (to.meta.requireAuth) {
//         let admin = localStorage.getItem("admin") ? JSON.parse(localStorage.getItem("admin")) : {}
//         if (admin) {
//             next()
//         } else {
//             next({
//                 path: "/login",
//                 query: { redirect: to.path }
//             })
//         }
//     } else {
//         next()
//     }
// })

export default router