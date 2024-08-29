#our first prog
.data
msg1: .asciiz "enter the number:"
msg2: .asciiz "the number entered is:"

.text
.globl main
main:

li $v0, 4
la $a0, msg1
syscall

li $v0, 5
syscall

move $t0, $v0
li $v0, 4
la $a0, msg2
syscall

li $v0,1
move $a0, $t0
syscall

li $v0, 10
syscall