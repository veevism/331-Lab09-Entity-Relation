<template>
    <label v-if="label">{{ label }}</label>
    <select class="field" :value="modelValue" v-bind="{
        ...$attrs,
        onChange: ($event) => { $emit('update:modelValue', $event.target.value) }
    }">
        <option v-for="option in options" :value="option.id" :key="option.id" :selected="option.id === modelValue">{{
            option.name }}</option>
    </select>
</template>
  
<script>
export default {
    props: {
        label: {
            type: String,
            default: ''
        },
        modelValue: {
            type: [String, Number, Object], // เพิ่ม Object เพื่อรองรับข้อมูลที่เป็น Object ด้วย
            default: ''
        },
        options: {
            type: Array,
            required: true
        }
    }
}
</script>
  