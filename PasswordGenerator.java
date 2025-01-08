import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configurações personalizadas
        System.out.println("Bem-vindo ao Gerador de Senhas!");
        System.out.print("Digite o comprimento desejado para a senha: ");
        int length = scanner.nextInt();

        System.out.print("Incluir letras maiúsculas? (S/N): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("S");

        System.out.print("Incluir letras minúsculas? (S/N): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("S");

        System.out.print("Incluir números? (S/N): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("S");

        System.out.print("Incluir caracteres especiais? (S/N): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("S");

        // Gera a senha
        String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecial);
        System.out.println("Sua senha gerada é: " + password);
    }

    private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
            boolean includeNumbers, boolean includeSpecial) {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String special = "!@#$%^&*()-_=+<>?";

        StringBuilder characterPool = new StringBuilder();
        if (includeUppercase)
            characterPool.append(uppercase);
        if (includeLowercase)
            characterPool.append(lowercase);
        if (includeNumbers)
            characterPool.append(numbers);
        if (includeSpecial)
            characterPool.append(special);

        // Garantir que haja caracteres disponíveis
        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("Pelo menos uma opção deve ser selecionada para gerar a senha.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}
