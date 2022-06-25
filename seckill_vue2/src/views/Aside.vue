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
          <el-menu-item index="/product">
            <i class="el-icon-s-home"></i>
            <span slot="title">秒杀产品</span>
          </el-menu-item>
          <el-menu-item index="/order">
            <i class="el-icon-shopping-cart-2"></i>
            <span slot="title">已购产品</span>
          </el-menu-item>
          <el-menu-item index="/person">
            <i class="el-icon-user-solid"></i>
            <span slot="title">个人中心</span>
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