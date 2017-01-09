			.data
space:		.asciiz " "
newLine: 	.asciiz "\n"
newPara: 	.asciiz "\n\n\n\n\n\n"
			.globl main
			.text
main:	li $t0, -4
		li $t1, -2147483648
		li $t2, 2147483648
		li $t3, 65

		srl $t4, $t0, 2
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		sra $t4, $t0, 2
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		sll $t4, $t0, 1
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		rol $t4, $t0, 2
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		ror $t4, $t0, 2
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		xor $t4, $t0, $t1
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		xor $t4, $t1, -8
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		add $t4,$t0, $t1
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		addu $t4, $t0,$t1
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		mul  $t4, $t1,$t2
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		mulo $t4,$t1,$t2
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		mulou $t4,$t0,$t0
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		mulou $t4,$t3,$t3
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		div   $t4, $t1,$t0
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		div $t4, $t3,$t0
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall

		divu $t4, $t1,$t0
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall

		sub  $t4, $t1,$t0
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall

		subu  $t4, $t1,$t0
		move $a0, $t4
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
	
		mult $t1,$t2
		mfhi $a0
		li $v0, 1
		syscall
		la $a0, newLine
		li $v0, 4
		syscall
		mflo $a0
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
		multu $t0, $t3
		mfhi $a0
		li $v0, 1
		syscall
		la $a0, newLine
		li $v0, 4
		syscall
		mflo $a0
		li $v0, 1
		syscall
		la $a0, newPara
		li $v0, 4
		syscall
		
end:	li $v0, 10
		syscall