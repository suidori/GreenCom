<template>
  <div>
    <h1>MyAA = {{ name }}</h1>
  </div>
</template>

<script>
export default {
    props: {
        name: {
            type: String,
            required: true
        }
    }
}
</script>

<style lang="scss" scoped></style>
