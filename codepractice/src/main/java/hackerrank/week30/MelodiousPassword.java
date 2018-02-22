package hackerrank.week30;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * There are rules for valid passwords and needs to write a program to generate
 * all possible passwords that meet those rules.
 * 
 * - a password consists of exactly n lowercase English letters. - The password
 * is melodious: meaning that consonants can only be next to vowels and vowels
 * can only be next to consonants. Example: bawahaha - The password cannot
 * contain the y letter (because it's both a consonant and vowel) - The first
 * letter of the password can be either a vowel or consonant
 * 
 * https://www.hackerrank.com/contests/w30/challenges/melodious-password
 * 
 * @author ozkansari
 *
 */
public class MelodiousPassword {

	private static final char[] CONSONANTS = "bcdfghjklmnpqrstvwxz"
			.toCharArray();
	private static final char[] VOVELS = "aeiou".toCharArray();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		calculate(n);

		in.close();
	}

	/**
	 * 
	 * @param n
	 *            [1,6] the length of the password
	 * @return each of the possible passwords, one per line. The order of the
	 *         passwords does not matter.
	 */
	private static void calculate(int n) {

		switch (n) {
		case 1:
			for (char c1 : CONSONANTS) {
				System.out.println(c1);
			}
			for (char c1 : VOVELS) {
				System.out.println(c1);
			}
			break;
		case 2:
			for (char c1 : CONSONANTS) {
				for (char c2 : VOVELS) {
					char[] current = { c1, c2 };
					System.out.println(new String(current));
				}
			}
			for (char c1 : VOVELS) {
				for (char c2 : CONSONANTS) {
					char[] current = { c1, c2 };
					System.out.println(new String(current));
				}
			}
			break;
		case 3:
			for (char c1 : CONSONANTS) {
				for (char c2 : VOVELS) {
					for (char c3 : CONSONANTS) {
						char[] current = { c1, c2, c3 };
						System.out.println(new String(current));
					}
				}
			}
			for (char c1 : VOVELS) {
				for (char c2 : CONSONANTS) {
					for (char c3 : VOVELS) {
						char[] current = { c1, c2, c3 };
						System.out.println(new String(current));
					}
				}
			}
			break;
		case 4:
			for (char c1 : CONSONANTS) {
				for (char c2 : VOVELS) {
					for (char c3 : CONSONANTS) {
						for (char c4 : VOVELS) {
							char[] current = { c1, c2, c3, c4 };
							System.out.println(new String(current));
						}
					}
				}
			}
			for (char c1 : VOVELS) {
				for (char c2 : CONSONANTS) {
					for (char c3 : VOVELS) {
						for (char c4 : CONSONANTS) {
							char[] current = { c1, c2, c3, c4 };
							System.out.println(new String(current));
						}
					}
				}
			}
			break;
		case 5:
			for (char c1 : CONSONANTS) {
				for (char c2 : VOVELS) {
					for (char c3 : CONSONANTS) {
						for (char c4 : VOVELS) {
							for (char c5 : CONSONANTS) {
								char[] current = { c1, c2, c3, c4, c5 };
								System.out.println(new String(current));
							}
						}
					}
				}
			}
			for (char c1 : VOVELS) {
				for (char c2 : CONSONANTS) {
					for (char c3 : VOVELS) {
						for (char c4 : CONSONANTS) {
							for (char c5 : VOVELS) {
								char[] current = { c1, c2, c3, c4, c5 };
								System.out.println(new String(current));
							}
						}
					}
				}
			}
			break;
		case 6:
			for (char c1 : CONSONANTS) {
				for (char c2 : VOVELS) {
					for (char c3 : CONSONANTS) {
						for (char c4 : VOVELS) {
							for (char c5 : CONSONANTS) {
								for (char c6 : VOVELS) {
									char[] current = { c1, c2, c3, c4, c5, c6 };
									System.out.println(new String(current));
								}
							}
						}
					}
				}
			}
			for (char c1 : VOVELS) {
				for (char c2 : CONSONANTS) {
					for (char c3 : VOVELS) {
						for (char c4 : CONSONANTS) {
							for (char c5 : VOVELS) {
								for (char c6 : CONSONANTS) {
									char[] current = { c1, c2, c3, c4, c5, c6 };
									System.out.println(new String(current));
								}
							}
						}
					}
				}
			}
			break;

		}
	}

}
