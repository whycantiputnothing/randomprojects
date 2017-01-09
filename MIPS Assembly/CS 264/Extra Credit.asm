			.data
array:	.word 2,4,5,7,8,11,13,16,19,22,30,40
space:		.asciiz " "
newLine: 	.asciiz "\n"
			.globl main
			.text
main:	li $t0, 12
		li $t1,3
		la $t2, array
loop1:	lw $a0, ($t2)
		li $v0, 1
		syscall
		la $a0, space
		li $v0, 4
		syscall
		addi $t0, $t0, -1
		beqz $t0, end
		addi $t1, $t1, -1
		addi $t2, $t2, 4
		beqz	$t1, line
		b loop1
line:	li $t1,3
		la $a0,newLine
		li $v0,4
		syscall
		b loop1
end:	li $v0, 10
		syscall