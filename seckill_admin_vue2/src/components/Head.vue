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
        <h1 style="font-size: 30px">湖南三湘银行秒杀管理系统</h1>
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
            <i style="margin-right: 5px" class="el-icon-user"></i>admin
        </span>
        <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>
            <span style="text-decoration: none;font-size:13px;margin:5px">退出</span>
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
            admin: localStorage.getItem("admin") ? JSON.parse(localStorage.getItem("admin")) : {}
        }
    },
    methods: {
        load(){
            this.user = localStorage.getItem("admin") ? JSON.parse(localStorage.getItem("admin")) : {}
        }
    },
    mounted() {
        this.load()
    },
}
</script>

<style>

</style>