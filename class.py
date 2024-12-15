import os

# Diretório atual
current_dir = os.getcwd()

# Loop pelos arquivos .java no diretório atual
for file_name in os.listdir(current_dir):
    if file_name.endswith(".java"):
        # Nome da classe baseado no nome do arquivo (sem extensão)
        class_name = os.path.splitext(file_name)[0]

        # Conteúdo do arquivo
        content = f"public class {class_name} {{\n\n}}"

        # Escrever no arquivo
        with open(file_name, "w") as file:
            file.write(content)

print("Classes criadas com sucesso!")
