#our first prog
.data
msg: .asciiz "this is our first program"

.text
.globl main
main:

li $v0, 4
la $a0, msg
syscall

li $v0, 10
syscall