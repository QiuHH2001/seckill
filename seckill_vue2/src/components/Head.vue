<template>
  <div style="width:100%">
    <el-header
        style="
        width:100%;
        font-size: 12px;
        border-bottom: 1px solid #ccc;
        line-height: 60px;
        display: flex;
        "
    >
        <div style="flex: 1">
        <h1 style="font-size: 30px">欢迎使用湖南三湘银行秒杀系统</h1>
        </div>
        <el-dropdown>
        <span
            class="el-dropdown-link"
            style="
            margin-right: 10px;
            cursor: pointer;
            font: 18px;
            font-weight: bold;
            "
        >
            <i style="margin-right: 5px" class="el-icon-user"></i>{{user.name}}
        </span>
        <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>
            <router-link to="/person" style="text-decoration: none">个人信息</router-link>
            </el-dropdown-item>
            <el-dropdown-item>
            <span style="text-decoration: none" @click="logout">退出</span>
            </el-dropdown-item>
        </el-dropdown-menu>
        </el-dropdown>
    </el-header>
  </div>
</template>

<script>
export default {
    name:'head',
    data() {
        return {
            user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
        }
    },
    methods: {
        logout(){
            this.$router.push("/login")
            localStorage.removeItem("user")
            this.$message.success("退出成功")
        },
        load(){
            this.user = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
        }
    },
    mounted() {
        this.load()
    },
}
</script>

<style>

</style>