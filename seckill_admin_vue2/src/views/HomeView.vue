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
import Aside from '@/components/Aside.vue';
import Head from '@/components/Head.vue';
// @ is an alias to /src

export default {
  name: 'HomeView',
  components: {
    Aside,
    Head,
},
};
</script>
