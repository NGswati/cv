.data
comma: .asciiz ","

.text
.globl main
main:
li $t0, 0
li $t1, 1
li $t2, 20
li $v0, 1
move $a0, $t0
syscall

addi $t2, -1

li $v0, 4
la $a0, comma
syscall

li $v0, 1
move $a0, $t1
syscall

addi $t2, -1

li $t3, 0

loop:
add $t3, $t0, $t1
move $t0, $t1
move $t1, $t3

li $v0, 4
la $a0, comma
syscall

li $v0, 1
move $a0, $t3
syscall
addi $t2, -1

bne $t2, 0, loop

li $v0, 10
syscall