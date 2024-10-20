<template>
  <div :style='{"border":"2px solid #a4d9b7","padding":"20px","margin":"20px auto 0","borderRadius":"8px","flexWrap":"wrap","background":"#fff","width":"1200px","position":"relative"}'>
    <div class="section-title" :style='{"padding":"20px 0","margin":"20px 0 20px 0","borderColor":"rgba(72, 197, 117,.8)","color":"#333","textAlign":"center","overflow":"hidden","borderRadius":"8px","background":"url(http://codegen.caihongy.cn/20221104/468cb37a5a4e43e89db0db4acaf0ea39.png) #e1f7e9 no-repeat center 10px","borderWidth":"1px 1px 4px 1px","width":"100%","fontSize":"28px","lineHeight":"76px","borderStyle":"solid","height":"120px"}'>信息交流</div>
    <el-form class="add-update-preview" :model="form" :rules="rules" ref="form" label-width="200px">
      <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="标题" prop="title">
        <el-input v-model="form.title" placeholder="请输入标题"></el-input>
      </el-form-item>
      <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="类型" prop="isdone">
        <el-radio-group v-model="form.isdone">
          <el-radio label="开放">公开</el-radio>
          <el-radio label="关闭">私人</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="内容" prop="content">
        <quill-editor ref="myTextEditor"
          v-model="form.content"
          :config="editorOption"
          @ready="onEditorReady($event)">
        </quill-editor>
      </el-form-item>
      <el-form-item :style='{"padding":"0","margin":"8px 0 0 0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"20px 40px 20px 260px","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"20px","background":"#47b144","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="submitForm('form')">{{this.isEdit ? '修改' : '发布帖子'}} </el-button>
        <el-button :style='{"border":"2px solid #3db769","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#3db769","borderRadius":"20px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="resetForm('form')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        form: {
          title: '',
          isdone: '开放',
          content: '',
          parentid: 0,
          userid: localStorage.getItem('userid'),
          username: localStorage.getItem('username')
        },
        editorOption: {
          modules: {
            toolbar: [
              ["bold", "italic", "underline", "strike"],
              ["blockquote", "code-block"],
              [{ header: 1 }, { header: 2 }],
              [{ list: "ordered" }, { list: "bullet" }],
              [{ script: "sub" }, { script: "super" }],
              [{ indent: "-1" }, { indent: "+1" }],
              [{ direction: "rtl" }],
              [{ size: ["small", false, "large", "huge"] }],
              [{ header: [1, 2, 3, 4, 5, 6, false] }],
              [{ color: [] }, { background: [] }],
              [{ font: [] }],
              [{ align: [] }],
              ["clean"],
              ["image", "video"]
            ]
          }
        },
        isEdit: false,
        rules: {
          title: [
            { required: true, message: '请输入标题', trigger: 'blur' }
          ]
        }
      }
    },
    created() {
      if (this.$route.query.id != undefined) {
        this.isEdit = true;
        this.form = Object.assign({}, JSON.parse(this.$route.query.editObj));
      }
    },
    //方法集合
    methods: {
      onEditorReady(editor) {
        editor.root.setAttribute('data-placeholder', "请输入内容...");
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post(`forum/${this.isEdit ? 'update' : 'add'}`, this.form).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: `${this.isEdit ? '修改' : '发布'}成功`,
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    if (this.isEdit) {
                      this.$router.push('/index/myForumList');
                    } else {
                      this.$router.push('/index/forum');
                    }
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .add-update-preview .el-form-item /deep/ .el-form-item__label {
        padding: 0 10px 0 0;
        color: #666;
        font-weight: 500;
        width: 200px;
        font-size: 14px;
        line-height: 40px;
        text-align: right;
      }
  
  .add-update-preview .el-form-item /deep/ .el-form-item__content {
    margin-left: 200px;
  }
  
  .add-update-preview .el-input /deep/ .el-input__inner {
        border: 1px solid #9ce0b5;
        border-radius: 4px;
        padding: 0 12px;
        box-shadow: inset 0px 0px 48px 0px #cef1db;
        outline: none;
        color: #666;
        width: 80%;
        font-size: 14px;
        height: 40px;
      }
  
  .add-update-preview .el-select /deep/ .el-input__inner {
        border: 1px solid #9ce0b5;
        border-radius: 4px;
        padding: 0 10px;
        box-shadow: inset 0px 0px 48px 0px #cef1db;
        outline: none;
        color: #666;
        width: 200px;
        font-size: 14px;
        height: 40px;
      }
  
  .add-update-preview .el-date-editor /deep/ .el-input__inner {
        border: 1px solid #9ce0b5;
        border-radius: 4px;
        padding: 0 10px 0 30px;
        box-shadow: inset 0px 0px 48px 0px #cef1db;
        outline: none;
        color: #666;
        width: 200px;
        font-size: 14px;
        height: 40px;
      }
  
  .add-update-preview /deep/ .el-upload--picture-card {
  	background: transparent;
  	border: 0;
  	border-radius: 0;
  	width: auto;
  	height: auto;
  	line-height: initial;
  	vertical-align: middle;
  }
  
  .add-update-preview /deep/ .upload .upload-img {
        border: 1px solid #9ce0b5;
        cursor: pointer;
        border-radius: 6px;
        box-shadow: inset 0px 0px 48px 0px #cef1db;
        color: #3db769;
        width: 200px;
        font-size: 32px;
        line-height: 120px;
        text-align: center;
        height: auto;
      }
  
  .add-update-preview /deep/ .el-upload-list .el-upload-list__item {
        border: 1px solid #9ce0b5;
        cursor: pointer;
        border-radius: 6px;
        box-shadow: inset 0px 0px 48px 0px #cef1db;
        color: #3db769;
        width: 200px;
        font-size: 32px;
        line-height: 120px;
        text-align: center;
        height: auto;
      }
  
  .add-update-preview /deep/ .el-upload .el-icon-plus {
        border: 1px solid #9ce0b5;
        cursor: pointer;
        border-radius: 6px;
        box-shadow: inset 0px 0px 48px 0px #cef1db;
        color: #3db769;
        width: 200px;
        font-size: 32px;
        line-height: 120px;
        text-align: center;
        height: auto;
      }
  
  .add-update-preview .el-textarea /deep/ .el-textarea__inner {
        border: 1px solid #9ce0b5;
        border-radius: 4px;
        padding: 12px;
        box-shadow: inset 0px 0px 48px 0px #cef1db;
        outline: none;
        color: #666;
        width: 80%;
        font-size: 14px;
        min-height: 180px;
      }
</style>
