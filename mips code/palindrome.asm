.data
msg: .asciiz "enter no."
msg1: .asciiz "is palindrome "
msg2: .asciiz "not palindrome"

.text
.globl main
main:

li $v0, 4
la $a0, msg
syscall

li $v0, 5
syscall
move $t0, $v0
move $t1, $t0

li $t2, 0
loop:
rem $t3, $t0, 10
mul $t2, $t2, 10
div $t0, $t0, 10
add $t2, $t2, $t3

bne $t0, 0, loop

beq $t2, $t1, pal
li $v0, 4
la $a0, msg2
syscall

j exit

pal:
li $v0, 4
la $a0, msg1
syscall

exit:
li $v0, 10
syscall