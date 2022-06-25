<template>
  <div style="height: 100%">
    <el-container>
      <Aside/>
      <el-container direction="vertical">
        <!-- <Aside/>  -->
        <Head style="width:100%"/>
        <router-view/>
      </el-container>
    </el-container>
  </div> 
</template>

<script>
// @ is an alias to /src
import Aside from "./Aside.vue"
import SeckillProduct from "@/components/SeckillProduct.vue";
import Head from "@/components/Head.vue";

export default {
  name: "HomeView",
  components: {
    Aside,
    SeckillProduct,
    Head
},
};
</script>

<style scoped>

</style>