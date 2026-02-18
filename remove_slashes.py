import os
import re

def process_file(filepath):
    with open(filepath, 'r', encoding='utf-8') as f:
        content = f.read()

    new_content = content
    
    # Files using YAML syntax or Frontmatter
    if filepath.endswith(('.yml', '.md')):
        # YAML: url: /path/ -> url: /path
        # Capture the key and value up to the slash.
        # Ensure we don't match "url: /" (length 1 path) by requiring at least one char after / before the trailing / or just checking content.
        # Regex: `url:\s+` then capture `/\S+` (path starting with / and having more chars) then `/` at end.
        
        # Matches: url: /basic/ -> url: /basic
        # Non-Matches: url: /
        new_content = re.sub(r'(url:\s+/[^/\s]+(?:/[^/\s]+)*)/(\s|$)', r'\1\2', new_content)
        
        # Also clean up permalinks if they exist in frontmatter? 
        # User said "links", usually implies navigation. But consistent URIs are good.
        # Let's stick to 'url:' key in YAML specifically as per previous context?
        # But wait, markdown files have [link](/path/).
        
    # Markdown/HTML links
    if filepath.endswith(('.md', '.html')):
        # Markdown: [text](/path/) -> [text](/path)
        # Match `](/path` then `/` then `)`
        # Avoid matching `](/)`
        new_content = re.sub(r'(\]\(/.+?)/(\))', r'\1\2', new_content)
        
        # HTML: href="/path/" -> href="/path"
        # Match `href="/path` then `/` then `"`
        # Avoid matching `href="/"`
        new_content = re.sub(r'(href="/.+?)/(")', r'\1\2', new_content)

    if new_content != content:
        print(f"Modifying {filepath}")
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(new_content)

def main():
    target_dir = 'src'
    for root, dirs, files in os.walk(target_dir):
        for file in files:
            if file.endswith(('.yml', '.md', '.html')):
                process_file(os.path.join(root, file))

if __name__ == "__main__":
    main()
