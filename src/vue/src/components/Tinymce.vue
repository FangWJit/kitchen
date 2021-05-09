<template>
    <div>
        <Editor id="tinymce" v-model="tinymceHtml" :init="init" @onChange="changes" upload-url="http://baidu/uploadImg"></Editor>
    </div>
</template>

<script>
    import tinymce from 'tinymce/tinymce'
    import 'tinymce/themes/silver/theme'
    import Editor from '@tinymce/tinymce-vue'
    import 'tinymce/skins/ui/oxide/skin.css'
    import 'tinymce/plugins/image' // 插入上传图片插件
    import 'tinymce/plugins/link' // 插入链接
    import 'tinymce/plugins/code' // 插入代码
    import 'tinymce/plugins/preview' // 插入预览
    import 'tinymce/icons/default/icons'
    import 'tinymce/plugins/media' // 插入视频插件
    import 'tinymce/plugins/table' // 插入表格插件
    import 'tinymce/plugins/lists' // 列表插件
    import 'tinymce/plugins/contextmenu'
    import 'tinymce/plugins/wordcount' // 字数统计插件
    import 'tinymce/plugins/paste' // 粘贴
    import 'tinymce/plugins/autolink' // 链接
    import 'tinymce/plugins/insertdatetime' // 链接
    import 'tinymce/plugins/hr' // 分割线
    import 'tinymce/plugins/colorpicker'
    import 'tinymce/plugins/textcolor'
    export default {
        name: "Tinymce",
        components: {Editor},
        data(){
            return{
                tinymceHtml:'请输入内容',
                init: {
                    language_url: '/tinymce/zh_CN.js',
                    language: 'zh_CN',
                    // skin_url: '/tinymce/skins/ui/oxide',
                    height: 500,
                    plugins: ['image', 'link', 'code', 'preview', 'media', 'table', 'paste', 'wordcount', 'lists', ], //插件
                    toolbar:[
                        'bold italic underline strikethrough | fontsizeselect | forecolor backcolor | alignleft aligncenter alignright alignjustify | bullist numlist | outdent indent blockquote | undo redo | link unlink image code | removeformat'
                    ],
                    branding: false,
                    images_upload_handler: (blobInfo, success, failure) => {
                        let base64 = "data:image/png;base64," + blobInfo.base64();
                        //编辑器的上传图片内容被处理为<img src="success方法里面的参数" />
                        success(base64);
                    }
                },
                uploadUrl: {
                    type: String,
                    required: true
                }
            }
        },
        mounted() {
            console.log(this)
            tinymce.init({})
        },
        methods:{
            changes(){
                var value = this.tinymceHtml
                this.$emit('inc',value)
            },
            images_upload_handler(blobInfo, success, failure, progress) {
                var _this =this;
                // tinymce api文档查阅可知   直接获取blob原始数据
                var blob = blobInfo.blob();
                // 原生上传
                var fd = new FormData();
                fd.append("file", blob);
                // console.log(_this.uploadUrl, fd);
                // 上传到 通用上传接口   oss里
                this.$request.post(_this.uploadUrl, fd)
                    .then(res => {
                        const resData = res.data;
                        if (resData.code == "S") {
                            // 固定写法  为了符合 tinymce的 上传成功回调显示
                            success(resData.ossUrl);
                            // 这里用于实现  把上传后的 url 直接以img形式拼接到 					富文本内容中的光标处
                            // window.tinymce
                            //   .get(_this.tinymceId)
                            //   .insertContent(`<imgsrc="${resData.ossUrl}" >`);
                        }
                    })
                    .catch(err => {
                        failure("出现未知问题");
                        console.log(err);
                    });
            }
        }

    }
</script>

<style scoped>

</style>