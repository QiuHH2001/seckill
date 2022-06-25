<template>
  <div>
    <el-aside
        width="200px" 
        style="text-color: #fff;
                box-shadow: 2px 0 6px rgb(0 21 41 / 35%);
                min-height: 100vh;
                background-color: rgb(84, 92, 100);
                ">
        <div style="margin: 20px 10px">
          <img src="../assets/HNlogo.png" style="width: 80%" />
        </div>
        <el-menu
          router
          :default-active="path"
          class="el-menu-vertical-demo"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
        >
          <el-menu-item index="/setting">
            <i class="el-icon-s-tools"></i>
            <span slot="title">秒杀设置</span>
          </el-menu-item>
          <el-menu-item index="/situation">
            <i class="el-icon-s-order"></i>
            <span slot="title">秒杀情况</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
  </div>
</template>

<script>
export default {
    name:'Aside',
    data() {
        return {
            path: this.$route.path
        }
    },
}
</script>

<style>

</style>