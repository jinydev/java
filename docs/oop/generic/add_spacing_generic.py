import os
import re

target_dir = '/Users/hojin8/docs/070.강의/d02.객체지향자바프로그래밍/src/oop/generic'
files = [
    'bounded-type.md',
    'generic-method.md',
    'generic-type.md',
    'index.md',
    'quiz.md',
    'wildcard.md'
]

def process_file(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        lines = f.readlines()

    new_lines = []
    in_code_block = False
    
    for i, line in enumerate(lines):
        if line.strip().startswith('```'):
            in_code_block = not in_code_block
        
        # Check if line is a H2 header and not in code block
        if not in_code_block and line.startswith('## '):
            # Check if previous line is already <br> or similar to avoid dupes
            is_already_spaced = False
            if new_lines:
                last_line = new_lines[-1].strip()
                if last_line == '<br>':
                    is_already_spaced = True
            
            if not is_already_spaced:
                 if i > 0: 
                    new_lines.append('\n<br>\n\n')
        
        new_lines.append(line)

    content = ''.join(new_lines)
    
    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(content)
    print(f"Processed {file_path}")

for filename in files:
    file_path = os.path.join(target_dir, filename)
    if os.path.exists(file_path):
        process_file(file_path)
    else:
        print(f"File not found: {file_path}")
