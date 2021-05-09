<template>
    <div class="about">
        <vHeader></vHeader>
        <div class="content-box" style="position: absolute;width: 100%;margin: 0 auto" :class="{ 'content-collapse': collapse }">
            <div class="content">
                <router-view v-slot="{ Component }">
                    <component :is="Component" />
                </router-view>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        computed: {
            tagsList() {
                return this.$store.state.tagsList.map(item => item.name);
            },
            collapse() {
                return this.$store.state.collapse;
            }
        }
    };
</script>
