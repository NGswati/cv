.data
msg1: .asciiz "enter the string"
msg2: .asciiz "the string is:"

buf1: .space 64

.text
.globl main
main:

li $v0, 4
la $a0, msg1
syscall

li $v0, 8
la $a0, buf1
li $a1, 64
syscall

li $v0, 4
la $a0, buf1
syscall

li $v0, 10
syscall