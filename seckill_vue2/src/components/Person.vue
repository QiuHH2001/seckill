<template>
  <div style="margin: 30px 20px">
  <el-card style="width:500px">
    <el-form
    style="margin-top:30px"
        :model="user"
        :rules="rules"
        ref="userform"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="用户名" prop="name">
          <el-input size="medium" prefix-icon="el-icon-user" v-model="user.name" placeholder="用户名" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="身份证号" prop="identity">
          <el-input :disabled="true" size="medium" prefix-icon="el-icon-user" v-model="user.identity" placeholder="身份证号" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input clear="" size="medium" prefix-icon="el-icon-lock" v-model="user.password" placeholder="密码" style="width:300px" show-password></el-input>
        </el-form-item>

        <el-form-item>
          <el-button style="margin-top = 50px; margin-left = 50px ;margin-right:50px" type="primary" @click="update" size="medium">确认修改</el-button>
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>
      </el-card>
  </div>
</template>

<script>
export default {
  name:'person',
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      rules: {
        name: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 3, max: 20, message: "长度在 3 到 20 个字符", trigger: "blur" },
        ],
        identity: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 3, max: 20, message: "长度在 3 到 20 个字符", trigger: "blur" },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 6, max: 20, message: "长度在 6 到 20 个字符", trigger: "blur" },
        ],
      },
    }
  },
  created(){
    this.user.password = ""
  },
  methods: {
    update(){
      this.request.put("/user/update", this.user).then(res => {
        if(res.code === 200){
          this.$message.success("修改成功")
          localStorage.setItem("user", JSON.stringify(this.user))
        }
      })
    }
  },
};
</script>

<style>
</style>